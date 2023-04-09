import React, { useRef, useState } from 'react';
import './chat.css';
import { HiOutlineLogout, HiOutlineCheck } from 'react-icons/hi';
import firebase from 'firebase/compat/app';
import 'firebase/compat/firestore';
import 'firebase/compat/auth';

import { useAuthState } from 'react-firebase-hooks/auth';
import { useCollectionData } from 'react-firebase-hooks/firestore';
import AppHeader from '../../app/AppHeader';

firebase.initializeApp({
  apiKey: "AIzaSyCuA964vi77pW6bYdcppeWO3SBIPE3vmvE",
  authDomain: "chat-app-c7f43.firebaseapp.com",
  projectId: "chat-app-c7f43",
  storageBucket: "chat-app-c7f43.appspot.com",
  messagingSenderId: "880152962673",
  appId: "1:880152962673:web:d03c1a2d1c99fe9a99ddd0",
  measurementId: "G-Y9G1ZD9CFJ"
});

const auth = firebase.auth();
const firestore = firebase.firestore();

function Chat() {

  const [user] = useAuthState(auth);
  return (
      <div className="Chamt">
        <AppHeader></AppHeader>
      <header>
        <h1 style={{fontSize:"25px"}}>Chat Room</h1>
        <SignOut />
      </header>

      <section>
        {user ? <ChatRoom /> : <SignIn />}
      </section>

    </div>
  );
}

function SignIn() {

  const signInWithGoogle = () => {
    const provider = new firebase.auth.GoogleAuthProvider();
    auth.signInWithPopup(provider);
  }

  return (
  <>
    <button className="sign-in button" onClick={signInWithGoogle}>Sign in with Google</button>
  </>
  )

}

function SignOut() {
  return auth.currentUser && (
    <button style={{backgroundColor:"transparent"}} class="button" onClick={() => auth.signOut()}><HiOutlineLogout /></button>
  )
} 

function ChatRoom() {

  const dummy = useRef();
  const messagesRef = firestore.collection('messages');
  const query = messagesRef.orderBy('createdAt').limitToLast(25);

  const [messages] = useCollectionData(query, { idField: 'id' });
  
  const [formValue, setFormValue] = useState('');

  const sendMessage = async(e) => {
    e.preventDefault();
    
    const { uid, photoURL } = auth.currentUser;

    await messagesRef.add({
      text: formValue,
      createdAt: firebase.firestore.FieldValue.serverTimestamp(),
      uid,
      photoURL
    });

    setFormValue('');
    dummy.current.scrollIntoView({ behavior: 'smooth' });
  }

  return (<>
    <main>
      {messages && messages.map(msg => <ChatMessage key={msg.id} message={msg} />)}

   <span ref={dummy}></span>
  </main>

    <form class="form" onSubmit={sendMessage}>
      <input class="input" value={formValue} onChange={(e) => setFormValue(e.target.value)} placeholder="say something nice" />
      <button class="button" type="submit" disabled={!formValue}><HiOutlineCheck/></button>
    </form>
</>)
}

function ChatMessage(props) {
  const { text, uid, photoURL } = props.message;
  const messageClass = uid === auth.currentUser.uid ? 'sent' : 'received';

  return (<>
    <div className={`message ${messageClass}`}>
      <img class="img" src={photoURL} />
      <p>{text}</p>
    </div>
  </>)
}

export default Chat;
