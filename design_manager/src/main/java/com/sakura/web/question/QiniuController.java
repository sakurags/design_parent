package com.sakura.web.question;

import com.qiniu.util.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins ="*")
public class QiniuController {

	@GetMapping("/plugin/qiniu/uptoken")
	public Map<String, String> upToken(){
		String accessKey = "bu5FymoLHBVjcKpbpGOV4dVj0FjVl3ZdriB7gEr6";
		String secretKey = "qLUaL_f_OULefE4D8T8d6v5R_mF29byO-pD709vu";
		String bucket = "studenttest";
		// 默认不指定key的情况下，以文件内容的hash值作为文件名
		Auth auth = Auth.create(accessKey, secretKey);
		String upToken = auth.uploadToken(bucket);
		
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put("uptoken", upToken);
		return hashMap;
	}
	
	
}
