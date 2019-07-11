/**
 * 
 */
package com.csf.whoami.utilities;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author TuanDQ
 *
 */
public class FileUntils {
	private byte[] getImageBytes(BufferedImage image, String imageFormat) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		BufferedOutputStream os = new BufferedOutputStream(bos);
		image.flush();
		ImageIO.write(image, imageFormat, os);
		os.flush();
		os.close();
		return bos.toByteArray();
	}

	private void fileDelete(String org_path, String thum_path) throws Exception {

		// 保存先Directoryチェック
		File file = new File(org_path);
		boolean exists = file.exists();
		boolean success = false;

		if (exists) {
			success = (new File(org_path)).delete();
		}
		// サムネイル削除

		// 保存先Directoryチェック
		file = new File(thum_path);
		exists = file.exists();
		success = false;

		if (exists) {
			success = (new File(thum_path)).delete();

		}
	}

	private static String getSuffix(String fileName, String fileType) {
		if (fileName == null) {
			return null;
		}
		int point = fileName.lastIndexOf(".");
		if (point != -1) {
			return fileName.substring(point + 1);

		}

		if ("blob".equals(fileName.substring(point + 1))) {
			return fileType.split("/")[1];
		}

		return fileName;
	}

//	private static BufferedImage reSize(BufferedImage img, int width, int height) throws Exception {
//	    ResampleOp resampleOp = new ResampleOp(width, height);
//	    resampleOp.setFilter(ResampleFilters.getLanczos3Filter());
//	    resampleOp.setUnsharpenMask(AdvancedResizeOp.UnsharpenMask.None);
//	    BufferedImage rescaled = resampleOp.filter(img, null);
//
//	    return rescaled;
//	  }
//	}

	/*
	private void videoUpload(MultipartFile image, String thumb, int filetype, String orgdir, String thumdir,
			String filename) throws FileUploadException {

		System.out.println("コンテキストパス(video):" + env.getProperty("alubum.save.path"));
		try {
			// byte[] org_buff = image.getBytes();

			String imageFormat = image.getContentType().substring(6);

			String org_filename = filename + "." + getSuffix(image.getOriginalFilename(), image.getContentType());

			// FileOutputStream org_out = null;
			File org_out = null;
			FileOutputStream thum_out = null;

			// オリジナル画像保存 ---- START -----
			String org_file_dir = new StringBuilder(env.getProperty("alubum.save.path")).append(orgdir).toString();
			String org_file_path = new StringBuilder(org_file_dir).append(org_filename).toString();
			File org_file = new File(org_file_dir);

			if (!org_file.exists()) {
				// 新規Directory作成
				org_file.setReadable(true, true);
				org_file.setWritable(true, true);
				org_file.setExecutable(true, true);
				org_file.mkdirs();
			}

			// ファイルを書く
//		      org_out = new FileOutputStream(org_file_path, false);
//		      org_out.write(org_buff, 0, org_buff.length);
//		      org_out.close();
			InputStream fileStream = image.getInputStream();
			File targetFile = new File(org_file_path);
			Files.copy(fileStream, targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
			IOUtils.closeQuietly(fileStream);

			// オリジナル画像保存 ---- END -----

			// サムネイル画像保存 ---- START -----
			String thum_file_dir = new StringBuilder(env.getProperty("alubum.save.path")).append(thumdir).toString();
			String thum_file_path = new StringBuilder(thum_file_dir).append(org_filename).toString();
			File thum_file = new File(thum_file_dir);

			if (!thum_file.exists()) {
				// 新規Directory作成
				thum_file.setReadable(true, true);
				thum_file.setWritable(true, true);
				thum_file.setExecutable(true, true);
				thum_file.mkdirs();
			}

			// 動画
			// 最後の『 . 』の位置を取得します。
			// 動画サムネイル
			int lastDotPosition = thum_file_path.lastIndexOf(".");

			// 『 . 』が存在する場合
			if (lastDotPosition != -1) {
				// Copy duong dan file upload cua device ios qua duong dan chinh thuc
				thum_file_path = thum_file_path.substring(0, lastDotPosition) + ".jpg";
				String sourcePath = thumb;
				sourcePath = sourcePath.replace("../upload", env.getProperty("alubum.save.path"));
				String destinationPath = thum_file_path;
				System.out.println(sourcePath);
				System.out.println(destinationPath);
				Path source = Paths.get(sourcePath);
				Path destination = Paths.get(destinationPath);
				boolean exist = Files.exists(source, new LinkOption[] { LinkOption.NOFOLLOW_LINKS });
				System.out.println(exist ? "file nguon ton tai" : "file khong ton tai");
				try {
					Files.move(source, destination);
				} catch (FileAlreadyExistsException e) {
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		} catch (Exception e) {
			throw new FileUploadException();
		}
		// サムネイル画像保存 ---- END -----
	}
	*/

	/*
	private void fileUpload(MultipartFile image, int filetype, String orgdir, String thumdir, String filename)
			throws FileUploadException {

		System.out.println("コンテキストパス:" + env.getProperty("alubum.save.path"));

		try {

			byte[] org_buff = image.getBytes();
			String imageFormat = image.getContentType().substring(6);

			String org_filename = filename + "." + getSuffix(image.getOriginalFilename(), image.getContentType());

			FileOutputStream org_out = null;
			FileOutputStream thum_out = null;

			// オリジナル画像保存 ---- START -----
			String org_file_dir = new StringBuilder(env.getProperty("alubum.save.path")).append(orgdir).toString();
			String org_file_path = new StringBuilder(org_file_dir).append(org_filename).toString();
			File org_file = new File(org_file_dir);

			if (!org_file.exists()) {
				// 新規Directory作成
				org_file.setReadable(true, true);
				org_file.setWritable(true, true);
				org_file.setExecutable(true, true);
				org_file.mkdirs();
			}

			// ファイルを書く
			org_out = new FileOutputStream(org_file_path, false);
			org_out.write(org_buff, 0, org_buff.length);
			org_out.close();
			// オリジナル画像保存 ---- END -----

			// サムネイル画像保存 ---- START -----
			String thum_file_dir = new StringBuilder(env.getProperty("alubum.save.path")).append(thumdir).toString();
			String thum_file_path = new StringBuilder(thum_file_dir).append(org_filename).toString();
			File thum_file = new File(thum_file_dir);

			if (!thum_file.exists()) {
				// 新規Directory作成
				thum_file.setReadable(true, true);
				thum_file.setWritable(true, true);
				thum_file.setExecutable(true, true);
				thum_file.mkdirs();
			}

			if (filetype == 0) {
				// 画像の場合
				BufferedImage src = ImageIO.read(new ByteArrayInputStream(org_buff));
				int iw = src.getWidth();
				int ih = src.getHeight();
				double x = 1;
				if (iw > ih) {
					if (iw > CommonTool.IMAGE_MAX_WIDTH) {
						x = CommonTool.IMAGE_MAX_WIDTH / (double) iw;
						if (ih * x > CommonTool.IMAGE_MAX_HEIGHT) {
							x = x * CommonTool.IMAGE_MAX_HEIGHT / (double) (ih * x);
						}
					}

				} else {
					if (ih > CommonTool.IMAGE_MAX_HEIGHT) {
						x = CommonTool.IMAGE_MAX_HEIGHT / (double) ih;
						if (iw * x > CommonTool.IMAGE_MAX_WIDTH) {
							x = x * CommonTool.IMAGE_MAX_WIDTH / (double) (iw * x);
						}
					}
				}

				BufferedImage img = ImageIO.read(new File(org_file_path));
				BufferedImage after = reSize(img, (int) (iw * x), (int) (ih * x));
				// BufferedImage after=reSize2(new File(org_file_path),(int)(iw*x),(int)(ih*x));
				byte[] resize_buff = getImageBytes(after, imageFormat);

				// ファイルを書く
				thum_out = new FileOutputStream(thum_file_path, false);
				thum_out.write(resize_buff, 0, resize_buff.length);
				thum_out.close();
			} else if (filetype == 1) { // 動画
				// 最後の『 . 』の位置を取得します。
				// 動画サムネイル
				int lastDotPosition = thum_file_path.lastIndexOf(".");

				// 『 . 』が存在する場合
				if (lastDotPosition != -1) {
					thum_file_path = thum_file_path.substring(0, lastDotPosition) + ".jpg";
					org_file = new File(org_file_path);
					this.slice(org_file, thum_file_path);
				}

			}
		} catch (Exception e) {
			throw new FileUploadException();
		}
	}
	*/

	/*
	private void imageUpload(MultipartFile image, int filetype, String orgdir, String thumdir, String filename)
			throws FileUploadException {

		System.out.println("コンテキストパス(image):" + env.getProperty("alubum.save.path"));
		try {
			byte[] org_buff = image.getBytes();

			String imageFormat = image.getContentType().substring(6);

			String org_filename = filename + "." + getSuffix(image.getOriginalFilename(), image.getContentType());

			FileOutputStream org_out = null;
			FileOutputStream thum_out = null;

			// オリジナル画像保存 ---- START -----
			String org_file_dir = new StringBuilder(env.getProperty("alubum.save.path")).append(orgdir).toString();
			String org_file_path = new StringBuilder(org_file_dir).append(org_filename).toString();
			File org_file = new File(org_file_dir);

			if (!org_file.exists()) {
				// 新規Directory作成
				org_file.setReadable(true, true);
				org_file.setWritable(true, true);
				org_file.setExecutable(true, true);
				org_file.mkdirs();
			}

			// ファイルを書く
			org_out = new FileOutputStream(org_file_path, false);
			org_out.write(org_buff, 0, org_buff.length);
			org_out.close();
			// オリジナル画像保存 ---- END -----

			// サムネイル画像保存 ---- START -----
			String thum_file_dir = new StringBuilder(env.getProperty("alubum.save.path")).append(thumdir).toString();
			String thum_file_path = new StringBuilder(thum_file_dir).append(org_filename).toString();
			File thum_file = new File(thum_file_dir);

			if (!thum_file.exists()) {
				// 新規Directory作成
				thum_file.setReadable(true, true);
				thum_file.setWritable(true, true);
				thum_file.setExecutable(true, true);
				thum_file.mkdirs();
			}

			BufferedImage src = ImageIO.read(new ByteArrayInputStream(org_buff));
			int iw = src.getWidth();
			int ih = src.getHeight();
			double x = 1;
			if (iw > ih) {
				if (iw > CommonTool.IMAGE_MAX_WIDTH) {
					x = CommonTool.IMAGE_MAX_WIDTH / (double) iw;
					if (ih * x > CommonTool.IMAGE_MAX_HEIGHT) {
						x = x * CommonTool.IMAGE_MAX_HEIGHT / (double) (ih * x);
					}
				}

			} else {
				if (ih > CommonTool.IMAGE_MAX_HEIGHT) {
					x = CommonTool.IMAGE_MAX_HEIGHT / (double) ih;
					if (iw * x > CommonTool.IMAGE_MAX_WIDTH) {
						x = x * CommonTool.IMAGE_MAX_WIDTH / (double) (iw * x);
					}
				}
			}

			BufferedImage img = ImageIO.read(new File(org_file_path));
			BufferedImage after = reSize(img, (int) (iw * x), (int) (ih * x));
			byte[] resize_buff = getImageBytes(after, imageFormat);

			// ファイルを書く
			thum_out = new FileOutputStream(thum_file_path, false);
			thum_out.write(resize_buff, 0, resize_buff.length);
			thum_out.close();

		} catch (Exception e) {
			throw new FileUploadException();
		}

		// サムネイル画像保存 ---- END -----
	}
	*/
}
