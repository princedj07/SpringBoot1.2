package com.springboot.rest.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.InputStreamResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@RestController
public class StreamingResponseBodyController {

	// 1. Download using StreamingResponseBody
	@RequestMapping(value = "downloadFile", method = RequestMethod.GET)
	public StreamingResponseBody getSteamingFile(HttpServletResponse response) throws IOException {
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=\"StreamingResponseBody.pdf\"");
		// Specify the location of file
		InputStream inputStream = new FileInputStream(new File("D://temp//h.pdf"));
		return outputStream -> {
			int nRead;
			byte[] data = new byte[1024];
			while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
				System.out.println("Writing some bytes..");
				outputStream.write(data, 0, nRead);
			}
		};
	}

	// 2. Download using InputStream to HttpServletResponse
	@RequestMapping(value = "downloadFile1", method = RequestMethod.GET)
	public void getSteamingFile1(HttpServletResponse response) throws IOException {
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=\"InputStream.pdf\"");
		InputStream inputStream = new FileInputStream(new File("D://temp//h.pdf"));
		int nRead;
		while ((nRead = inputStream.read()) != -1) {
			response.getWriter().write(nRead);
		}
	}

	// 3. Download using InputStreamResource
	@RequestMapping(value = "downloadFile2", method = RequestMethod.GET)
	public InputStreamResource FileSystemResource(HttpServletResponse response) throws IOException {
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=\"InputStreamResource.pdf\"");
		InputStreamResource resource = new InputStreamResource(new FileInputStream("D://temp//h.pdf"));
		return resource;
	}
}