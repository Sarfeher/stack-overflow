import { useEffect, useState } from 'react'
import './App.css'

function App() {

  useEffect(() => {
    const fetchData = async () => {
        const response = await fetch("/api/questions/all");
        const data = await response.json();
        console.log(data);
    }

    fetchData();
  }, [])

  return (
    <>
      Hello asd
    </>
  )
}

export default App
