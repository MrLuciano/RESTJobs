package net.my.spring.model;

import java.io.Serializable;


/**
 * Model para Job
 * @author Luciano Marinho
 *
 */
public class Job implements Serializable {

	/**
	 * serial uid
	 */
	private static final long serialVersionUID = 4479496087337324081L;
	
	private String name;
	private String msg;
	private String cron;
	
	/**
	 * @param name
	 * @param msg
	 * @param cron
	 */
	public Job(String name, String msg, String cron) {
		this.name = name;
		this.msg = msg;
		this.cron = cron;
	}
	
	public Job() {
		this.name = "";
		this.msg = "";
		this.cron = "";
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the cron
	 */
	public String getCron() {
		return cron;
	}

	/**
	 * @param cron the cron to set
	 */
	public void setCron(String cron) {
		this.cron = cron;
	}
	
}
