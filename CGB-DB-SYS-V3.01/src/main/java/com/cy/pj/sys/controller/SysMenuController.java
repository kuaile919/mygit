package com.cy.pj.sys.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.entity.SysMenu;
import com.cy.pj.sys.service.SysMenuService;
//所有返回值都要返回Json字符串时可以加这个注解
@RestController	//------@Controller +   @ResponseBody所有方法上都有这个注解，这个类的return就不能写页面了，是字符串
@RequestMapping("/menu/")
public class SysMenuController {
	@Autowired
    private SysMenuService sysMenuService;
	//name=delete&parentId=1&url=...
	@RequestMapping("doSaveObject")
	public JsonResult doSaveObject(SysMenu entity) {
	   sysMenuService.saveObject(entity);
	   return new JsonResult("save ok");
	}
	@RequestMapping("doUpdateObject")
	public JsonResult doUpdateObject(SysMenu entity) {
		sysMenuService.updateObject(entity);
		return new JsonResult("update ok");
	}
	
	
	@RequestMapping("doFindZtreeMenuNodes")
	public JsonResult doFindZtreeMenuNodes() {
		return new JsonResult(sysMenuService.findZtreeMenuNodes());
	}
	
	@RequestMapping("doDeleteObject")
	public JsonResult doDeleteObject(Integer id) {
		sysMenuService.deleteObject(id);
		return new JsonResult("delete ok");
	}
	
	@RequestMapping("doFindObjects")
	public JsonResult doFindObjects() {
		return new JsonResult(sysMenuService.findObjects());
	}
	
	
}


