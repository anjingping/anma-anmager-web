package fun.anma.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import fun.anma.common.utils.JsonUtil;
import fun.anma.utils.ImgException;
import fun.anma.utils.OSSClientUtil;

@Controller
public class PictureController {

	@RequestMapping("/pic/upload")
	@ResponseBody
	public String uploadFile(MultipartFile uploadFile){
		HashMap result = new HashMap();
		//接收上传的文件
		//获取扩展名
		try {
			String originalFilename = uploadFile.getOriginalFilename();
			originalFilename.substring(originalFilename.lastIndexOf(".")+1);
			//上传到阿里云OSS图片服务器
			OSSClientUtil ossClient = new OSSClientUtil();
			System.out.println("创建过来了");
			String name = ossClient.uploadImg2Oss(uploadFile);
			name = "img/"+name;
			System.out.println(name);
			String url = ossClient.getUrl(name);
			System.out.println(url);
			//返回是否错误及地址
			result.put("error", 0);
			result.put("url", url);
			return JsonUtil.ObjectToJson(result);
		} catch (ImgException e) {
			e.printStackTrace();
			result.put("error", 1);
			result.put("message", "上传图片失败！");
			return JsonUtil.ObjectToJson(result);
		}
		
		
	}
}
