package com.server.action;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.server.entity.Rssi;
import com.server.service.IRssiService;
import com.server.utils.Data;


public class RssiAction extends ActionSupport implements ServletResponseAware {
	private static final long serialVersionUID = -8591740195041164457L;
	private IRssiService rssiService;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Double x;
	private Double y;
	private String bssid;
	private String ssid;
	private Integer rssi;
	
	private String result;
	

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	@org.apache.struts2.json.annotations.JSON(serialize=false)
	public IRssiService getRssiService() {
		return rssiService;
	}

	public void setRssiService(IRssiService rssiService) {
		this.rssiService = rssiService;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}


	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public String getBssid() {
		return bssid;
	}

	public void setBssid(String bssid) {
		this.bssid = bssid;
	}

	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public Integer getRssi() {
		return rssi;
	}

	public void setRssi(Integer rssi) {
		this.rssi = rssi;
	}

	public void collectRssi() {
		try {
			this.response.setContentType("text/json;charset=utf-8");
			this.response.setCharacterEncoding("UTF-8");
			Map<String, String> json = new ConcurrentHashMap<String, String>();
			Rssi rs = new Rssi();
			rs.setBssid(bssid);
			rs.setSsid(ssid);
			rs.setRssi(rssi);
			rs.setX(x);
			rs.setY(y);			
			if (rssiService.collectRssi(rs)) {
				json.put("message", "录入成功！");
			} else {
				json.put("message", "录入失败！");
			}
			byte[] jsonBytes = json.toString().getBytes("utf-8");
			response.setContentLength(jsonBytes.length);
			response.getOutputStream().write(jsonBytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void SelectOption() throws IOException{
		List<Data> list = new ArrayList<Data>();
		for(int i = 0; i < 80; i++){
			Data data = new Data();
			data.setBookname("第"+ i +"排");
			list.add(data);
		}
		setResult(JSON.toJSON(list).toString());
		try {
			response.setContentType("text/json;charset=utf-8");
			response.setCharacterEncoding("UTF-8");
			byte[] jsonBytes = result.getBytes("utf-8");
			response.setContentLength(jsonBytes.length);
			response.getOutputStream().write(jsonBytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
