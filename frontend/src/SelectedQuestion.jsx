import { useEffect, useState } from 'react'
import './App.css'
import { Link, useNavigate, useParams } from 'react-router-dom';

function fetchQuestion(id) {
  return fetch("/api/questions/" + id).then(res => res.json())
}

function fetchAnswers(id) {
  return fetch("/api/answers/" + id).then(res => res.json());
}


function SelectedQuestion() {
    const [question, setQuestion] = useState();
    const [answers, setAnswers] = useState([]);

    const {id} = useParams();
    const navigate = useNavigate();


    function addNewAnswer() {
      navigate(`/answer/${id}`)
    }


    useEffect(() => {
      fetchQuestion(id).then(res => setQuestion(res));
      fetchAnswers(id).then(res => setAnswers(res));
    }, [])

    return(
        <>
      {question && 
      <div>
        <h1>{question.title}</h1> 
        <h2>{question.description}</h2>
        <h3>Asked by {question.userName}</h3>
        <button onClick={addNewAnswer}>
        Answer this question
        </button>
        <ul className='answerList'>
        {answers.map(answer => <li className='answers' key={answer.answer}><p>{answer.answer}</p><p>Answered by {answer.userName}</p></li>)}
        </ul>
        </div>}
      </>
    )
}

export default SelectedQuestion;