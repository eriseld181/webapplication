package com.crystal.webapplication.mappers;

import com.crystal.webapplication.dto.CommentDto;
import com.crystal.webapplication.models.Comment;

public class CommentMapper {
	
	//Take an object from the database
	//We map it as the object that will be returned to the user
	//Return this dto object created
	//We will call this method in the controller class

	public static CommentDto mappCommentToDto(Comment comment) {
		CommentDto commentDto= new CommentDto(comment.getComment_text(), comment.getComment_author(), comment.getComment_date());
		return commentDto;
	}
}
