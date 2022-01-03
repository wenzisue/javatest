package com.xiaowen.javatest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.ChannelSftp.LsEntry;

public class FetchLogs {
	public static void main(String args[]) {
		int[] nodeArray = {1,2,3,7,8,9};
		
		//downloadEintakeProdSystemLogs(nodeArray, true);
		
		downloadEintakeINTSystemLogs(true);
	}

	private static void downloadEintakeProdSystemLogs(int[] nodeArray, boolean onlySystemLogAndSystemErr) {
		JSch jsch = new JSch();
		
		for (int nodeNum : nodeArray) {
			try {
				Session session = jsch.getSession("wxiaowen", "wppnode" + nodeNum);
				session.setPassword("wxiaowen");
				session.setConfig("StrictHostKeyChecking", "no");
				session.connect();

				Channel channel = session.openChannel("sftp");
				channel.connect();

				ChannelSftp csftp = (ChannelSftp) channel;

				List<LsEntry> files = new ArrayList<LsEntry>();

				Vector<?> f = (Vector<?>) csftp
						.ls("/opt/IBM/WebSphere/AppServer/profiles/AppSrv01/logs/EintakeNode" + nodeNum);

				String ftpLocalDirectory = "C:\\Users\\xiaowen.wu\\Desktop\\prod_nodes_logs\\" + nodeNum + "\\";
				String ftpRemoteDirectory = "/opt/IBM/WebSphere/AppServer/profiles/AppSrv01/logs/EintakeNode" + nodeNum
						+ "/";

				Object[] arr = f.toArray();
				for (int i = 0; i < arr.length; i++) {
					LsEntry lsEntry = (LsEntry) arr[i];
					String filename = lsEntry.getFilename();
					
					if(onlySystemLogAndSystemErr) {
						if (filename.equals("SystemOut.log") || filename.equals("SystemErr.log")) {
							files.add(lsEntry);
							continue;
						}
					}

					File localFile = new File(ftpLocalDirectory + filename);

					if (filename.contains("log") && filename.contains("System")) {
						if (localFile.exists()) {
							Long localFileSize = Files.size(Paths.get(ftpLocalDirectory + filename));
							Long remoteFileSize = (long) lsEntry.getAttrs().getSize();
							if (!remoteFileSize.equals(localFileSize)) {
								files.add(lsEntry);
							}
						} else {
							files.add(lsEntry);
						}
					}
				}

				for (int i = 0; i < files.size(); i++)
					System.out.println("[" + (i + 1) + "] - " + files.get(i));

				System.out.println("Sftp download start for node " + nodeNum + "! " + LocalDateTime.now());

				for (int i = 0; i < files.size(); i++) {
					LsEntry lsEntry = (LsEntry) files.get(i);

					String outputFileName = ftpLocalDirectory + lsEntry.getFilename();

					File f1 = new File(outputFileName);

					csftp.get(ftpRemoteDirectory + lsEntry.getFilename(), new FileOutputStream(f1));
				}

				System.out.println("Sftp download complete for node " + nodeNum + "! " + LocalDateTime.now());

				channel.disconnect();
				session.disconnect();

			} catch (Exception e) {

				e.printStackTrace();
			}

		}
	}
	
	private static void downloadEintakeINTSystemLogs(boolean onlySystemLogAndSystemErr) {
		JSch jsch = new JSch();

		try {
			Session session = jsch.getSession("wxiaowen", "ortwas");
			session.setPassword("Wenzi77777!!!");
			session.setConfig("StrictHostKeyChecking", "no");
			session.connect();

			Channel channel = session.openChannel("sftp");
			channel.connect();

			ChannelSftp csftp = (ChannelSftp) channel;

			List<LsEntry> files = new ArrayList<LsEntry>();

			Vector<?> f = (Vector<?>) csftp
					.ls("/opt/IBM/WebSphere/AppServer/profiles/AppSrv01/logs/EintakeNode1");

			String ftpLocalDirectory = "C:\\Users\\xiaowen.wu\\Desktop\\int_logs\\";
			String ftpRemoteDirectory = "/opt/IBM/WebSphere/AppServer/profiles/AppSrv01/logs/EintakeNode1"
					+ "/";

			Object[] arr = f.toArray();
			for (int i = 0; i < arr.length; i++) {
				LsEntry lsEntry = (LsEntry) arr[i];
				String filename = lsEntry.getFilename();

				if (onlySystemLogAndSystemErr) {
					if (filename.equals("SystemOut.log") || filename.equals("SystemErr.log")) {
						files.add(lsEntry);
						continue;
					}
				}

				File localFile = new File(ftpLocalDirectory + filename);

				if (filename.contains("log") && filename.contains("System")) {
					if (localFile.exists()) {
						Long localFileSize = Files.size(Paths.get(ftpLocalDirectory + filename));
						Long remoteFileSize = (long) lsEntry.getAttrs().getSize();
						if (!remoteFileSize.equals(localFileSize)) {
							files.add(lsEntry);
						}
					} else {
						files.add(lsEntry);
					}
				}
			}

			for (int i = 0; i < files.size(); i++)
				System.out.println("[" + (i + 1) + "] - " + files.get(i));

			System.out.println("Sftp download start for node " + 1 + "! " + LocalDateTime.now());

			for (int i = 0; i < files.size(); i++) {
				LsEntry lsEntry = (LsEntry) files.get(i);

				String outputFileName = ftpLocalDirectory + lsEntry.getFilename();

				File f1 = new File(outputFileName);

				csftp.get(ftpRemoteDirectory + lsEntry.getFilename(), new FileOutputStream(f1));
			}

			System.out.println("Sftp download complete for node " + 1 + "! " + LocalDateTime.now());

			channel.disconnect();
			session.disconnect();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
