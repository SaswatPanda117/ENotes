package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.user.Notes;

public class NotesDao {

	private Connection con;
	
	public NotesDao(Connection con) {
		super();
		this.con = con;
	}
	
	public boolean AddNotes(String ti, String co, int ui) {
		boolean addNote = false;
		
		try {
			
			String query = "insert into notes (title, content, uid) values (?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, ti);
			ps.setString(2, co);
			ps.setInt(3, ui);
			int count = ps.executeUpdate();
			
			if(count == 1) {
				addNote = true;
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return addNote;
	}
	
	public List<Notes> getData(int id){
		
		List<Notes> list = new ArrayList<Notes>();
		Notes notes = null;
		
		try {
			
			String query = "select * from notes where uid=? order by id desc";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				notes = new Notes();
				
				notes.setId(rs.getInt(1));
				notes.setTitle(rs.getString(2));
				notes.setContent(rs.getString(3));
				notes.setPostDate(rs.getTimestamp(4));
				/* as the user is already login there is no need to show uid i.e. user id */
				
				list.add(notes);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Notes getDataById(int noteId) {
		Notes nt = null;
		
		try {
			
			String query = "select * from notes where id = ?";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, noteId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				nt = new Notes();
				nt.setId(rs.getInt(1));
				nt.setTitle(rs.getString(2));
				nt.setContent(rs.getString(3));
				
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return nt;
	}
	
	public boolean NotesUpdate(int nId, String nTitle, String nContent) {
		boolean dataUpdate = false;
		
		try {
			
			String query = "update notes set title=?, content=? where id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, nTitle);
			ps.setString(2, nContent);
			ps.setInt(3, nId);
			
			int count = ps.executeUpdate();
			
			if(count == 1) {
				dataUpdate = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dataUpdate;
	}
	
	public boolean DeleteNotes(int noteId) {
		
		boolean dataDelete = false;
		
		try {
			
			String query = "delete from notes where id=?";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, noteId);
			
			int count = ps.executeUpdate();
			
			if(count == 1) {
				dataDelete = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dataDelete;
	}
}
