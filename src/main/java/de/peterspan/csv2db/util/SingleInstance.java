package de.peterspan.csv2db.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

public class SingleInstance {

	static File lockFile = new File(System.getProperty("user.dir"), ".lock");
	static FileLock lock;
	static FileChannel in;

	public static File getLockFile() {
		return lockFile;
	}

	public static void setLockFile(File lockFile) {
		SingleInstance.lockFile = lockFile;
	}

	public static void lock() throws OverlappingFileLockException, LockException {
		try {
			if (!lockFile.exists())
				lockFile.createNewFile();
			in = new RandomAccessFile(lockFile, "rw").getChannel();

			FileLock tempLock = in.tryLock();
			if (tempLock == null)
				throw new OverlappingFileLockException();
		} catch (FileNotFoundException e) {
			throw new LockException("Can't lock file (" + lockFile.getAbsolutePath() + ")!", e);
		} catch (IOException ioe) {
			throw new LockException("Can't lock file (" + lockFile.getAbsolutePath() + ")!", ioe);
		}
	}

	public static void release() {
		try {
			lock.release();
			in.close();
		} catch (Exception e) {

		}
	}

	@SuppressWarnings("serial")
	public static class LockException extends Exception {
		public LockException() {
			super();
		}

		public LockException(String message, Throwable cause) {
			super(message, cause);
		}

		public LockException(String message) {
			super(message);
		}

		public LockException(Throwable cause) {
			super(cause);
		}
	}
}
