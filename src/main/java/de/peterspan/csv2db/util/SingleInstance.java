/**
 *  Copyright 2012-2013 Frederik Hahne, Christoph Stiehm
 *
 * 	This file is part of csv2db.
 *
 *  csv2db is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  csv2db is distributed in the hope that it will be useful,
 * 	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with csv2db.  If not, see <http://www.gnu.org/licenses/>.
 */
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
