export async function getPosts() {
  const response = await fetch(window.env.API_HOST + "/post");
  const jsonData = await response.json();
  return jsonData;
}

export async function addPost(post) {
  const response = await fetch(
    window.env.API_HOST +
      "/post/add?" +
      encodeURI(`name=${post.name}&content=${post.content}`),
    {
      method: "POST",
    }
  );
  return response.ok;
}
