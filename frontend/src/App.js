import React from "react";
import { BrowserRouter, Route, Link, Routes } from "react-router-dom";
import {ErrorBoundary} from 'react-error-boundary';
import LandingPage from "./components/views/LandingPage/LandingPage";
import MainPage from "./components/views/MainPage/MainPage";
import NotFound from "./components/views/NotFound/NotFound";
import Error from "./components/views/Error/Error";
import LoginPage from "./components/views/LoginPage/LoginPage";
import SignupPage from "./components/views/SignupPage/SignupPage";

function App() {
  return (
    <ErrorBoundary FallbackComponent={<Error />}>
      <BrowserRouter>
        <Routes>
          <Route exact path="/" element={<LandingPage />} />
          <Route exact path="/main" element={<MainPage />} />
          <Route exact path="/login" element={<LoginPage />} />
          <Route exact path="/signup" element={<SignupPage />} />
          <Route path={"*"} element={<NotFound />} />
        </Routes>
      </BrowserRouter>
    </ErrorBoundary>
  );
}
 
export default App;
