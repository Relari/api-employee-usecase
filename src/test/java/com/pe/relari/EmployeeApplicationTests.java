//package com.pe.relari;
//
//import com.pe.relari.employee.service.EmployeeCreateUseCase;
//import com.pe.relari.employee.util.GsonUtil;
//import com.pe.relari.employee.util.TestUtil;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
///**
// * Class: EmployeeApplicationTests.
// * @version 1.0.0
// * @author Relari
// */
//
//@SpringBootTest
//@AutoConfigureMockMvc
//class EmployeeApplicationTests {
//
//	@Value("${application.api.path}")
//	private String baseUrl;
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@Autowired
//	private EmployeeCreateUseCase demoService;
//
//	@BeforeEach
//	void init() {
//		demoService.save(TestUtil.buildEmployee());
//	}
//
//	@Test
//	void getDemosTest() throws Exception {
//		mockMvc.perform(get(baseUrl))
//				.andDo(print())
//				.andExpect(status().isOk());
//	}
//
//	@Test
//	void createDemoTest() throws Exception {
//
//		var demo = TestUtil.buildEmployeeRequest();
//
//		mockMvc.perform(post(baseUrl)
//						.contentType(MediaType.APPLICATION_JSON)
//						.content(GsonUtil.toJson(demo))
//				)
//				.andDo(print())
//				.andExpect(status().isCreated());
//	}
//
////	@Test
////	void createDemoButIsBadRequestTest() throws Exception {
////
////		var demo = new DemoRequest("");
////
////		mockMvc.perform(post(baseUrl)
////						.contentType(MediaType.APPLICATION_JSON)
////						.content(objectMapper.writeValueAsString(demo))
////				)
////				.andDo(print())
////				.andExpect(status().isBadRequest());
////	}
////
//	@Test
//	void foundDemoTest() throws Exception {
//		mockMvc.perform(get(baseUrl.concat("/1")))
//				.andDo(print())
//				.andExpect(status().isOk());
//	}
//
//	@Test
//	void demoNotFoundTest() throws Exception {
//		mockMvc.perform(get(baseUrl.concat("/0")))
//				.andDo(print())
//				.andExpect(status().isNotFound());
//	}
//
//	@Test
//	void deleteDemoTest() throws Exception {
//		mockMvc.perform(delete(baseUrl.concat("/1")))
//				.andDo(print())
//				.andExpect(status().isNoContent());
//	}
//
//}
