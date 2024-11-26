package com.tl.kp.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.tl.kp.dao.AttendanceServiceImpl;
import com.tl.kp.dao.UserServiceImpl;
import com.tl.kp.model.AttendanceDTI;
import com.tl.kp.model.User;

import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;



@ExtendWith(MockitoExtension.class)
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserServiceImpl userService;

    @Mock
    private AttendanceServiceImpl attendanceService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setup(WebApplicationContext context) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void testGetLogin() throws Exception {
        // Mock a user for login
        User user = new User();
        user.setUserName("testUser");
        user.setUserPassword("password");
        user.setUserType("User");

        Mockito.when(userService.getLogin("testUser", "password")).thenReturn(user);

        mockMvc.perform(post("/login")
                .param("userName", "testUser")
                .param("userPassword", "password"))
                .andExpect(status().isOk())
                .andExpect(view().name("HomePage"));
    }

    @Test
    void testViewReport() throws Exception {
        // Mock attendance records
        AttendanceDTI record1 = new AttendanceDTI();
        AttendanceDTI record2 = new AttendanceDTI();
        List<AttendanceDTI> records = Arrays.asList(record1, record2);

        Mockito.when(attendanceService.getAttendanceByUserId(1L)).thenReturn(records);

        mockMvc.perform(get("/View_Report/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("viewReport"))
                .andExpect(model().attributeExists("attendanceList"));
    }

    @Test
    void testAddTimeDate() throws Exception {
        mockMvc.perform(post("/saveDateTime")
                .param("localDate", "2024-11-08")
                .param("localTime", "10:30:00 AM"))
                .andExpect(status().isOk())
                .andExpect(view().name("logOut"))
                .andExpect(model().attributeExists("loginInfo"));
    }

    @Test
    void testAddTimeDateOut() throws Exception {
        AttendanceDTI loginInfo = new AttendanceDTI();
        loginInfo.setLocalDate(LocalDate.now());
        loginInfo.setLocalTimeIN(LocalTime.of(10, 30));

        HttpSession session = mockMvc.perform(post("/saveLogoutTime")
                .sessionAttr("loginInfo", loginInfo))
                .andExpect(status().isOk())
                .andExpect(view().name("HomePage"))
                .andReturn().getRequest().getSession();

        Mockito.verify(attendanceService).addCart(loginInfo);
    }
}
