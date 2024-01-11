import { useEffect, useState } from 'react'
import './App.css'
import { Link, useParams } from 'react-router-dom';


function SelectedQuestion() {
    const [question, setQuestion] = useState();
    let {id} = useParams();


    useEffect(() => {
      const fetchData = async () => {
          const response = await fetch("/api/questions/" + id);
          const data = await response.json();
          setQuestion(data);
          console.log(data);
      }
  
      fetchData();
    }, [])
    return(
        <>
      {question && 
      <div> 
        <h3> Asked by {question.questionUserName}</h3>
        <h1> Title: {question.title}</h1> 
        <h2>Question: {question.description}</h2>
        
        </div>}
      </>
    )
}

export default SelectedQuestion;