let posts = [
    {
        id: "1",
        title: "Post 1",
        description: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        comments : [
            {
                name: 'John',
                description: 'This is the first comment'
            },
            {
                name: 'Smith',
                description: 'This is the second comment'
            }
        ]
    },
    {
        id: "2",
        title: "Post 2",
        description: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        comments : [
            {
                name: 'Charles',
                description: 'This is the first comment'
            },
            {
                name: 'Banle',
                description: 'This is the first comment'
            }
        ]
    }
];

let current_post = 0;

function addNewComment(post, postDiv) {
    //  Add new comment section
    let leave_comment = document.createElement('h4');
    leave_comment.textContent = 'Leave a comment';
    postDiv.append(leave_comment);

    // Comments container
   let commentDiv = document.createElement('div');
   commentDiv.className = 'comment';
   postDiv.append(commentDiv);

   // Comment name div
   let commentNameDiv = document.createElement('div');
   commentNameDiv.className = 'comment-name';
   commentDiv.append(commentNameDiv);

   // Comment name label & text
   let commentNameLabel = document.createElement('label');
   commentNameLabel.textContent = 'NAME';
   commentNameDiv.append(commentNameLabel);
   let commentNameTextBox = document.createElement('input');
   commentNameTextBox.id = 'comemnt-name-new-'+post.id;
   commentNameTextBox.type = 'text';
   commentNameDiv.append(commentNameTextBox);


   // Comment desc div
   let commentDescDiv = document.createElement('div');
   commentDescDiv.className = 'comment-desc';
   commentDiv.append(commentDescDiv);

   // Comment desc label & text
   let commentDescLabel = document.createElement('label');
   commentDescLabel.textContent = 'COMMENT';
   commentDescDiv.append(commentDescLabel);
   let commentDescTextArea = document.createElement('textarea');
   commentDescTextArea.id = 'comemnt-desc-new-'+post.id;
   commentDescDiv.append(commentDescTextArea);

   // Add comment button
   let addCommentBtn = document.createElement('button');
   addCommentBtn.textContent = 'ADD COMMENT';
   addCommentBtn.className = 'add-comment-btn';
   addCommentBtn.id='add-comment-btn-'+post.id;
   addCommentBtn.disabled = true;
   commentDiv.append(addCommentBtn);

   commentNameTextBox.addEventListener('keyup', function(event) {
        if(commentNameTextBox.value !== '' && commentDescTextArea.value !== '') {
            addCommentBtn.disabled = false;
        } else {
            addCommentBtn.disabled = true;
        }
    });

    commentDescTextArea.addEventListener('keyup', function(event) {
        if(commentDescTextArea.value !== '' && commentNameTextBox.value !== '') {
            addCommentBtn.disabled = false;
        }else {
            addCommentBtn.disabled = true;
        }
    });

   addCommentBtn.addEventListener('click', function(event) {
       let buttonid = event.target.id;
       let postid = buttonid.split('-')[3];

       let comment_name =  document.getElementById('comemnt-name-new-'+postid).value;
       let comment_desc =  document.getElementById('comemnt-desc-new-'+postid).value;

       for(let i = 0; i < posts.length; i++) {
           if(postid === posts[i].id) {
                let comment = {
                    name: comment_name,
                    description: comment_desc
                }
               if(posts[i].comments) {
                    posts[i].comments.push(comment);
                   renderComment(comment, postDiv, posts[i].id);
               } else {
                   posts[i].comments = [];
                   posts[i].comments.push(comment);
                   renderComment(comment, postDiv, posts[i].id);
               }
           }
       }
   });
}

function renderComment(comment, postDiv, postid) {

    let oldCommentsDiv = document.getElementsByClassName('old-comments')[0];

    let oldCommentDiv = document.createElement('div');
    oldCommentDiv.className = 'old-comment';

    let commentName = document.createElement('div');
    commentName.className = 'name';
    commentName.textContent = comment.name;
    oldCommentDiv.append(commentName);

    let commentDesc = document.createElement('div');
    commentDesc.className = 'desc';
    commentDesc.textContent = comment.description;
    oldCommentDiv.append(commentDesc);

    oldCommentsDiv.append(oldCommentDiv);

    /*let deleteCommentBtn = document.createElement('button');
    deleteCommentBtn.textContent = 'Delete';
    deleteCommentBtn.id = 'delete-comment-btn-'+postid;
    oldCommentDiv.append(deleteCommentBtn);

    deleteCommentBtn.addEventListener('click', function(event) {
        let buttonid = event.target.id;
        let postid = buttonid.split('-')[3];
 
        for(let i = 0; i < posts.length; i++) {
            if(postid === posts[i].id) {
                for(let j = 0; i < posts[i].comments.length; j++) {
                    if(posts[i].comments[j].name === comment.name) {
                        posts[i].comments.splice(i,1);
                    }
                }
            }
        }
    });*/
}

function renderPost(post) {

    const posts_container = document.getElementById('posts-container');
    posts_container.innerHTML = '';

    // Post container
    let postDiv = document.createElement('div');
    postDiv.className = 'post';
    postDiv.id = 'post-'+post.id;
    posts_container.append(postDiv);

    // Post title
    let title = document.createElement('h2');
    title.textContent = post.title;
    postDiv.append(title);

    // Post desc
    let desc = document.createElement('p');
    desc.textContent = post.description;
    postDiv.append(desc);

    postDiv.append(document.createElement('hr'));

    let oldCommentsDiv = document.createElement('div');
    oldCommentsDiv.className = 'old-comments';
    postDiv.append(oldCommentsDiv);

    if(post.comments === null || post.comments === undefined || post.comments.length == 0) {
         // Be the first
        let msg = document.createElement('h4');
        msg.textContent = 'Be the first to comment';
        postDiv.append(msg);

    } else {
        post.comments.forEach((comment) => {
            renderComment(comment, postDiv, post.id);
        });
    }

    addNewComment(post, postDiv);
}

function renderPosts() {
    if(posts.length > 0){
        renderPost(posts[0]);
        current_post = 0;
    }
}

function prev() {
    if(current_post > 0) {
        current_post = current_post - 1;
        renderPost(posts[current_post]);
    }
}

function next() {
    if(current_post < posts.length - 1) {
        current_post = current_post + 1;
        renderPost(posts[current_post]);
    }
}

document.addEventListener('DOMContentLoaded', function(event) {
    renderPosts();
});