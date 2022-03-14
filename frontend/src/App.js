import React from "react";
import { BrowserRouter, Route, Link, Routes } from "react-router-dom";
import {ErrorBoundary} from 'react-error-boundary';
import LandingPage from "./components/views/LandingPage/LandingPage";
import MainPage from "./components/views/MainPage/MainPage";
import NotFound from "./components/views/NotFound/NotFound";
import Error from "./components/views/Error/Error";

function App() {
  return (
    <ErrorBoundary FallbackComponent={<Error />}>
      <BrowserRouter>
        <Routes>
          <Route exact path="/" element={<LandingPage />} />
          <Route exact path="/main" element={<MainPage />} />
          <Route path={"*"} element={<NotFound />} />
        </Routes>
      </BrowserRouter>
    </ErrorBoundary>
  );
}

export default App;
