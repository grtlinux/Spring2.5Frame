<%@ page contentType="text/html; charset=EUC-KR" %>
<html>
<head>
	<script type='text/javascript' src='/appc/comment/interface/listCommentService.js'></script>
	<script type='text/javascript' src='/appc/comment/interface/writeCommentService.js'></script>
	<script type='text/javascript' src='/appc/comment/engine.js'></script>
	<script type='text/javascript' src='/appc/comment/util.js'></script>
	<script type="text/javascript">
	window.onload = function() {
		listCommentService.getComments(onGetComments);
	}
	
	function writeComment() {
		var content = $('content');
		var newComment = {
			writerName: $('writerName').value,
			content: $('content').value
		};
		writeCommentService.write(newComment, onWriteComment);
	}
	
	var onGetComments = function(data) {
		for (var i = 0 ; i < data.length ; i++) {
			appendCommentToUI(data[i]);
		}
	}
	
	var onWriteComment = function(data) {
		appendCommentToUI(data);
	}
	
	function appendCommentToUI(comment) {
		var commentsDiv = $('comments');
		var newCommentDiv = document.createElement('div');
		newCommentDiv.id = 'comment'+comment.id;
		newCommentDiv.innerHTML = comment.writerName + ":" + comment.content;
		commentsDiv.appendChild(newCommentDiv);
	}
	</script>
</head>
<body>
<hr />
<form id="comment" name="comment">
<p>
	<label for="writerName">작성자:</label><br/>
	<input type="text" name="writerName" id="writerName" />
</p>
<p>
	<label for="content">내용:</label><br/>
	<textarea name="content" id="content"></textarea>
</p>
<p>
	<input type="button" value="등록" onclick="writeComment()" />
</p>
</form>
<hr/>
<div id="comments">
</div>
</body>
</html>
