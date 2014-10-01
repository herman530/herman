package com.zzp.action;

import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.zzp.model.User;
import com.zzp.service.UserService;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport {
	private List<User> _users;
	private UserService _userService = new UserService();
	private User _user;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return _user;
	}

	public void setUser(User user) {
		this._user = user;
	}

	public String add() {
		_userService.add(_user);
		return SUCCESS;
	}

	public String addInput() {
		return INPUT;
	}

	public String delete() {
		_userService.deleteById(id);
		return SUCCESS;
	}

	public String update() {
		_userService.update(_user);
		return SUCCESS;
	}

	public String updateInput() {
		this._user = this._userService.loadById(id);
		return INPUT;
	}

	public String list() throws SQLException {
		_users = _userService.list();
		return SUCCESS;
	}

	public UserService getUserService() {
		return _userService;
	}

	public void setUserService(UserService userService) {
		this._userService = userService;
	}

	public List<User> getUsers() {
		return _users;
	}

	public void setUsers(List<User> users) {
		this._users = users;
	}
}
