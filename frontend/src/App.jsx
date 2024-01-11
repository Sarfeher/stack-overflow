import { useEffect, useState } from 'react'
import './App.css'
import { Link } from 'react-router-dom';

function App() {
  const [questions, setQuestion] = useState([]);


  useEffect(() => {
    const fetchData = async () => {
        const response = await fetch("/api/questions/all");
        const data = await response.json();
        setQuestion(data);
    }

    fetchData();
  }, [])

  return (
    <>
      {questions.map(question => <Link to={"/question/" + question.id} key={question.id}> <div className='question'> <h2> {question.description
} </h2> <span> Asked by {question.questionUserName} </span> </div> </Link>)}
    </>
  )
}

export default App
