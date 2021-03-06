package com.example.libre;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat; 

public class Post {
	private Comment[] _commentList;
	private JSONObject _json;
	
	private String 	_title;
	private int		_id;
	private String 	_content;
	private Date 	_pubDate;
	private Date 	_modDate;
	private String 	_author;
	private String	_url;

	public Post(JSONObject json) {
		try {
			_title = json.getString("title");
			_id = json.getInt("id");
			_content = json.getString("content");
			_url = json.getString("url");
			_author = json.getJSONObject("author").getString("nickname");
			_json = json;

			String rawPubDate = json.getString("date");
			String rawModDate = json.getString("modified");
			try {
				_pubDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rawPubDate);
				_modDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rawModDate);
			} 
			catch (Exception e) 
			{
				throw new RuntimeException(e); 
			}
		}
		catch(JSONException e) {
			throw new RuntimeException(e);
		}
	};

	public String getTitle() {
		return _title;
	}

	public int getId() {
		return _id;
	}

	public String getContent() {
		return _content;
	}

	public Date getPubDate() {
		return _pubDate;
	}

	public Date getModDate() {
		return _modDate;
	}
	
	public String getAuthor() {
		return _author;
	}
	
	public String getUrl() {
		return _url;
	}

	public Comment[] getCommentsList() {
		return _commentList;
	}
	
	public String toString() {
		return _title;
	}
	
	public JSONObject getJson() {
		return _json;
	}
}
