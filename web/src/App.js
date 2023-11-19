import { useEffect, useState } from "react";
import Post from "./Post";
import { addPost, getPosts } from "./service/postService";
import { Form, Button, Stack } from "react-bootstrap";
import { getRandomName, setName, getName } from "./service/nameService";

function App() {
  const [posts, setPosts] = useState([]);
  const [nickname, setNickname] = useState("");
  const [userName, setUserName] = useState(null);
  const [timer, setTimer] = useState(0);

  useEffect(() => {
    updateName();
    setNickname(getRandomName());
    updatePosts();
  }, []);

  useEffect(() => {
    updatePosts();
    setTimeout(() => {
      setTimer(timer + 1);
    }, 1000);
  }, [timer]);

  const updatePosts = async () => {
    const p = await getPosts();
    p.sort((a, b) => b.id - a.id);
    setPosts(p);
  };

  const updateName = async () => {
    const result = await getName();
    setUserName(result);
  };

  return userName === null ? (
    <div
      style={{
        padding: "100px",
        display: "flex",
        flexDirection: "column",
        justifyContent: "center",
        height: "100vh",
      }}
    >
      <h1
        style={{
          textAlign: "center",
        }}
      >
        이름을 입력해 주세요
      </h1>
      <Form.Group className="mt-5">
        <Form.Control type="text" id="main_name_input"></Form.Control>
      </Form.Group>
      <Button
        className="mt-3"
        onClick={() => {
          const name = document.getElementById("main_name_input").value;
          setName(name).then(() => {
            setUserName(name);
          });
        }}
      >
        확인
      </Button>
    </div>
  ) : (
    <div className="p-5">
      <h1>{userName}의 방명록</h1>
      <Form
        style={{
          display: "flex",
          flexDirection: "column",
          marginBlock: "40px",
        }}
      >
        <Form.Group className="mb-2">
          <Form.Control
            id="name_input"
            type="text"
            name="name"
            value={nickname}
          />
        </Form.Group>
        <Form.Group className="mb-2">
          <Form.Control
            id="content_input"
            name="content"
            placeholder="남길 말을 적어주세요"
          />
        </Form.Group>
        <Button
          onClick={() => {
            const name = document.getElementById("name_input").value;
            const content = document.getElementById("content_input").value;
            addPost({ name, content }).then(() => {
              updatePosts();
            });
          }}
        >
          방명록 남기기
        </Button>
      </Form>
      <Stack gap={3}>
        {posts.map((post) => (
          <Post key={post.id} name={post.name} content={post.content} />
        ))}
      </Stack>
    </div>
  );
}

export default App;
