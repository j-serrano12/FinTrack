import React, { useState } from "react";

const UserForm = () => {
    const [formData, setFormData] = useState({
        username: '',
        email: '',
        password: '',
        firstName: '',
        lastName: ''
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value,
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await fetch('api/v1/users', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(formData),
            });


            if (response.ok) {
                const data = await response.json();
                console.log('Success', data);
                alert("User created successfully");

                // Optional: Clear the form after success
                setFormData({ username: '', email: '', password: '', firstName: '', lastName: '' });
            } else {
                console.error('Server error', response.statusText);
            }
        } catch (error) {
            console.error('Network error', error);
        }
    };


    return (
        <form onSubmit={handleSubmit} style={{ display: 'flex', flexDirection: 'column', maxWidth: '400px', gap: '10px' }}>
            <h2>Register User</h2>
            <input name="firstName" placeholder="First Name" value={formData.firstName} onChange={handleChange} />
            <input name="lastName" placeholder="Last Name" value={formData.lastName} onChange={handleChange} />
            <input name="username" placeholder="Username" value={formData.name} onChange={handleChange} />
            <input name="email" type="email" placeholder="Email" value={formData.email} onChange={handleChange} />
            <input name="password" type="password" placeholder="Password" value={formData.password} onChange={handleChange} />
            <button type="submit">Create User</button>
        </form>
    );
};

export default UserForm;