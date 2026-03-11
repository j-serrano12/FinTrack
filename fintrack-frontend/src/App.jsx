import 'bootstrap/dist/css/bootstrap.min.css';
import React from 'react';
import './App.css';
import UserForm from './components/UserForm/UserForm.jsx';
import { Container } from 'react-bootstrap';

function App() {
    return (

        <div className="App min-vh-100 bg-light">
            <Container className="py-5">
                <h1 className="text-center display-4 fw-bold text-primary">
                    Fintrack
                </h1>
                <p className="text-center text-muted">Manage your finances with ease</p>
                <hr className="my-4"/>

                <div className="row justify-content-center">
                    <div className="col-md-6">
                        <UserForm />
                    </div>
                </div>
            </Container>
        </div>
    );
}

export default App;