package com.dorel;

import jcifs.CIFSContext;
import jcifs.context.SingletonContext;
import jcifs.smb.NtlmPasswordAuthenticator;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;

public class AddFile {


	private String USER_NAME = null;
	private String PASSWORD = null;
	private String DOMAIN = null;
	private String NETWORK_FOLDER = null;
	public String content;
	public String file;

	public AddFile(String fileContent, String fileName) {

		content = fileContent;
		file = fileName;
	}
	public void copyFiles(String filePath, String user, String pass) throws Exception{
		String path = null;
		SmbFileOutputStream sfos = null;
		System.out.println("filePath: " + filePath);
		System.out.println("user: " + user);
		System.out.println("pass: " + pass);
		System.out.println("file: " + file);
		try {
			USER_NAME = user;
			PASSWORD = pass;
			DOMAIN = "";
			NETWORK_FOLDER = filePath;
			CIFSContext base = SingletonContext.getInstance();
			CIFSContext authed1 = base.withCredentials(new NtlmPasswordAuthenticator(DOMAIN, USER_NAME, PASSWORD));
			path = NETWORK_FOLDER + file;
			SmbFile newFile = new SmbFile(path, authed1);
			sfos = new SmbFileOutputStream(newFile);
			sfos.write(content.getBytes());
			System.out.println("File successfully created.");
			
		} catch (Exception e) {
			System.err.println("Unable to create file. Cause: " + e.getMessage() + e.getCause());
			throw new Exception("Unable to create file. Cause: " + file);
		} finally {
			sfos.close();
		}
		
	}
}
