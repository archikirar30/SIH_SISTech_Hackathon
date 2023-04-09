import React, { Component } from 'react';
import { Link, NavLink } from 'react-router-dom';
import './AppHeader.css';

class AppHeader extends Component {
    render() {
        return (
            <header className="app-header">
                <div className="container">
                    <div className="app-branding">
                        <Link to="/" className="app-title">KNOW YOUR NEIGHBORHOOD</Link>
                    </div>
                    <div className="app-options">
                        <nav className="app-nav">
                                { this.props.authenticated ? (
                                    <ul>
										<li>
											
                                            <NavLink to="/">Home</NavLink>        
                                        </li>
										<li>
											
                                            <NavLink to="/about">About Us</NavLink>        
                                        </li>
										<li>
											
                                            <NavLink to="/contact">Contact Us</NavLink>        
                                        </li>
										<li>
                                            <NavLink to="/add">Stores</NavLink>
                                        </li>
                                        <li>
                                            <NavLink to="/view">View Stores</NavLink>
                                        </li>
                                        <li>
                                            <NavLink to="/profile">Profile</NavLink>
                                        </li>

                                        <li>
                                            <NavLink to="/chat">Chat</NavLink>
                                        </li>
										
                                        <li>
                                            <a onClick={this.props.onLogout}>Logout</a>
                                        </li>
                                    </ul>
                                ): (
                                    <ul>
										 <li>
											
                                            <NavLink to="/">Home</NavLink>        
                                        </li>
										<li>
											
                                            <NavLink to="/about">About Us</NavLink>        
                                        </li>
										<li>
											
                                            <NavLink to="/contact">Contact Us</NavLink>        
                                        </li>
                                        <li>
                                            <NavLink to="/chat">Chat</NavLink>
                                        </li>
                                        <li>

                                            <NavLink to="/login">Login</NavLink>        
                                        </li>
                                        <li>
                                            <NavLink to="/signup">Register</NavLink> 

                                        </li>
                                    </ul>
                                )}
                        </nav>
                    </div>
                </div>
            </header>
        )
    }
}

export default AppHeader;