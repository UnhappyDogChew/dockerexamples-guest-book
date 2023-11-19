import React from "react";
import { Card } from "react-bootstrap";

export default function Post({ name, content }) {
  return (
    <Card>
      <Card.Body>
        <Card.Title>{name}</Card.Title>
        <Card.Text>{content}</Card.Text>
      </Card.Body>
    </Card>
  );
}
