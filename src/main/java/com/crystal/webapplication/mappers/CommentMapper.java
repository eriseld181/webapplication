package com.crystal.webapplication.mappers;

import com.crystal.webapplication.dto.CommentDto;
import com.crystal.webapplication.models.Comment;

public class CommentMapper {
//mer nje object nga db
//mapoje sipas objektit dto (konverto)-funksion qe mer nje comment model edhe kthen dto: krijohet objekti i ri
//do ta therrasim tek controller

	public static CommentDto mappCommentToDto(Comment comment) {
		CommentDto commentDto= new CommentDto(comment.getComment_text(), comment.getComment_author(), comment.getComment_date());
		return commentDto;
	}
}
