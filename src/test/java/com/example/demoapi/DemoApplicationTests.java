package com.example.demoapi;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demoapi.model.domain.Demo;
import com.example.demoapi.service.DemoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Class: DemoApplicationTests.
 * @version 1.0.0
 * @author Relari
 */

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	private static final ObjectMapper objectMapper = new ObjectMapper();

	@Value("${application.api.path}")
	private String baseUrl;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private DemoService demoService;

	@BeforeEach
	void init() {
		var demo = new Demo(1, "Demo 1");
		demoService.save(demo);
	}

	@Test
	void getDemosTest() throws Exception {
		mockMvc.perform(get(baseUrl))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	void createDemoTest() throws Exception {

		var demo = new Demo(1, "Demo 1");

		mockMvc.perform(post(baseUrl)
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(demo))
				)
				.andDo(print())
				.andExpect(status().isCreated());
	}

	@Test
	void foundDemoTest() throws Exception {
		mockMvc.perform(get(baseUrl.concat("/1")))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	void demoNotFoundTest() throws Exception {
		mockMvc.perform(get(baseUrl.concat("/0")))
				.andDo(print())
				.andExpect(status().isNotFound());
	}

	@Test
	void deleteDemoTest() throws Exception {
		mockMvc.perform(delete(baseUrl.concat("/1")))
				.andDo(print())
				.andExpect(status().isNoContent());
	}

}
