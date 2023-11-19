import { getRandomNickname } from "@woowa-babble/random-nickname";

const type = "animals";

export function getRandomName() {
  return getRandomNickname(type);
}

export async function getName() {
  const response = await fetch(window.env.API_HOST + "/info");
  const data = await response.json();
  return data.name;
}

export async function setName(name) {
  const response = await fetch(window.env.API_HOST + "/info?name=" + name, {
    method: "POST",
  });
  const data = await response.json();
  return data.name;
}
