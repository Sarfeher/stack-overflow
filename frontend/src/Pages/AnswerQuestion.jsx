import { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom';

function saveAnswer(questionId, answer, userName) {

    const answerObject = {
        questionId: parseInt(questionId, 10),
        answer,
        userName,
    };    

    fetch("/api/answers/", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(answerObject),
    }).then(res => res.json());
}

function Add() {
    const navigate = useNavigate();

    const {id} = useParams();
    const [answer, setAnswer] = useState("");
    const [name, setName] = useState("");

    function submit(e) {
        e.preventDefault()
        saveAnswer(id, answer, name);
        setName("");
        setAnswer("");
        navigate("/question/" + id);
    }

  return (
    <>
      <form onSubmit={submit}>
        <label>Answer:
            <textarea required rows="5" cols="33" value={answer} onChange={e => setAnswer(e.target.value)}> </textarea>
        </label>
        <label>Name:
            <input required value={name} onChange={e => setName(e.target.value)}></input>
        </label>
        <button type='submit'>Submit</button>
      </form>
    </>
  )
}

export default Add