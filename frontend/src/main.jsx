import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import Add from './Pages/Add.jsx'
import './index.css'
import Layout from './Pages/Layout.jsx'
import {createBrowserRouter, RouterProvider} from "react-router-dom";


const router = createBrowserRouter([
  {
    path: "/",
    element: <Layout />,
    children: [
      {
        path: "/",
        element: <App />
      },
      {
        path: "/add",
        element: <Add />
      }
    ]
  },
]);

ReactDOM.createRoot(document.getElementById("root")).render(
  <RouterProvider router={router} />
);
