import React, { useState } from 'react';
import { useDispatch } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import { registerUser } from '../../../_actions/user_action';
// import toast, { Toaster } from 'react-hot-toast';
import '../LoginPage/Accounts.css';
import axios from 'axios';
// import {Button } from 'react-bootstrap';

function RegisterPage(props) {
  let navigate = useNavigate();
  const dispatch = useDispatch();

  const [Email, setEmail] = useState('');
  const [Id, setId] = useState('');
  const [Password, setPassword] = useState('');
  const [ConfirmPasword, setConfirmPasword] = useState('');
  const [Name, setName] = useState('');
  const [Phone, setPhone] =useState('');
  const [BirthDay, setbirthday] =useState('');

  const check = () => {
    const id = Id;
    const pw = Password;
    const name = Name;
    const num = pw.search(/[0-9]/g);
    const eng = pw.search(/[a-z]/gi);
    const spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

    if (id.length < 6 || id.length > 15) {
      // toast.error('ID는 6자리 ~ 15자리 이내로 입력해주세요.');
      return false;
    } else if (pw.length < 8 || pw.length > 20) {
      // toast.error('비밀번호는 8자리 ~ 20자리 이내로 입력해주세요.');
      return false;
    } else if (pw.search(/\s/) !== -1) {
      // toast.error('비밀번호는 공백 없이 입력해주세요.');
      return false;
    } else if (num < 0 || eng < 0 || spe < 0) {
      // toast.error('영문,숫자, 특수문자를 혼합하여 입력해주세요.');
      return false;
    } else if (name.length < 1 || name.length > 6) {
      // toast.error('닉네임은 1자리 ~ 6자리 이내로 입력해주세요.');
      return false;
    } else {
      return true;
    }
  };


  const onEmailHandler = (e) => {
    setEmail(e.currentTarget.value);
  };

  const onIdHandler = (e) => {
    setId(e.currentTarget.value);
  };

  const onPasswordHanlder = (e) => {
    setPassword(e.currentTarget.value);
  };
  const onNameHanlder = (e) => {
    setName(e.currentTarget.value);
  };

  const onConfirmPasswordHandler = (e) => {
    setConfirmPasword(e.currentTarget.value);
  };



   // 아이디 중복 체크
   const idCheck = () => {
    axios({
      method: 'get',
      url: `https:/api/sign/checkid/?id=${Id}`,
    })
      .then((res) => {
        console.log(res.data);
        if (res.data.data === false) {
          // toast.success('사용할 수 있는 아이디입니다.')
          ;
        } else {
          // toast.error('이미 사용중인 아이디 입니다.');
        }
      })
      .catch((err) => {
        console.log(err);
      });
  };

   // 이메일 중복 체크
   const emailCheck = () => {
    axios({
      method: 'get',
      url: `https:/api/sign/checkemail?email=${Email}`,
    })
    .then((res) => {
      console.log(res.data);
      if (res.data.data === false) {
        // toast.success('사용할 수 있는 이메일입니다.')
        ;
      } else {
        // toast.error('이미 사용중인 이메일 입니다.');
      }
    })
    .catch((err) => {
      console.log(err);
    });
  };
  
  // 닉네임 중복 체크
  const nameCheck = () => {
    axios({
      method: 'get',
      url: `https:/api/sign/name?name=${Name}`,
    })
    .then((res) => {
      console.log(res.data);
      if (res.data.data === false) {
        // toast.success('사용할 수 있는 닉네임입니다.')
        ;
      } else {
        // toast.error('이미 사용중인 닉네임 입니다.');
      }
    })
    .catch((err) => {
      console.log(err);
    });
  };

  const onSubmit = (e) => {
		e.preventDefault();
    if (Id === '' || Id === undefined || Id === null) {
      // toast.error('ID를 입력하세요');
      return;
    }

    if (!check()) {
      return;
    }

		if (Password === ConfirmPasword) {

      axios.post('/api/sign/signup', 
      JSON.stringify({  
        email: Email,
        id: Id,
        password: Password,
        name: Name,
        type: 'none' }), 
      { headers: {
        "Content-Type": `application/json`,
      },
    })
    .then((res) => {
      console.log(res);
    });
		}
	};

  const onSubmitHandler = (e) => {
    e.preventDefault(); 
    if (Id === '' || Id === undefined || Id === null) {
      // toast.error('ID를 입력하세요');
      return;
    }

    if (!check()) {
      return;
    }

    if (Email === '' || Email === undefined || Email === null) {
      // toast.error('이메일을 입력하세요');
      return;
    }


    
    if (Password === ConfirmPasword) {
      const body = {
        email: Email,
        id: Id,
        password: Password,
        name: Name,
        type: 'none',

      };
        

      dispatch(registerUser(body))
      .then(() => { 
        // toast.success('회원가입이 완료되었습니다.');
        navigate("/login");
        
      });
    
    }else {
      // toast.error('비밀번호가 일치하지 않습니다');
    }
   };

   return (
  <div className='bod'>
  <form style={{
    display:'flex', justifyContent: 'center', alignItems: 'center'
    ,width: '100%', height: '100vh'}}
        onSubmit={onSubmitHandler}>
  <div style={{ height:'70vh', width:'160vh',  }}  class="signup-wrap">
    
	<div style={{marginTop:'0px',  marginBottom:'0px', paddingTop:'80px', paddingBottom:'0px'}} class="login-html">
    {/* <div style={{fontWeight:'bold' , marginTop:'0px', marginBottom:'0px', paddingTop:'0px', paddingBottom:'0px'}}><h1 className='headerst'>N:ear</h1></div> */}
    
		<input  style={{marginTop:'0px',  marginBottom:'0px', paddingTop:'0px', paddingBottom:'0px'}} id="tab-1" type="radio" name="tab" class="sign-in" onClick={()=>{ navigate('/login')}} /><label for="tab-1" class="tab">로그인</label>
    {/* SIGN IN버튼 누를 경우 login페이지로 랜더링되게 변경 */}
		<input style={{marginTop:'0px',  marginBottom:'0px', paddingTop:'0px', paddingBottom:'0px'}} id="tab-2" type="radio" name="tab" class="sign-up" checked /><label for="tab-2" class="tab">회원가입</label>
	 

     <div class="login-form">
   
        <div class="sign-up-htm">
          <div class="group">
            <label for="pass" class="label">이름</label>
            <input style={{ color:'black'}} id="pass" type="text" class="input" placeholder="1~6자 내로 입력해주세요." onChange={onNameHanlder}/>
            {/* <p style={{ marginTop:'8px' , marginLeft:'400px', fontSize:'17px', cursor:'pointer' }} onClick={()=>{nameCheck()}} >중복 체크</p> */}
          <div class="group">
            <label for="pass" class="label">생년월일</label>
            <input style={{ color:'black'}} id="pass" type="text" class="input" placeholder="생년월일 6자리를 입력해주세요" onChange={onConfirmPasswordHandler}/>
          </div>
          <div class="group">
            <label for="pass" class="label">휴대폰 번호</label>
            <input style={{ color:'black'}} id="pass" type="text" class="input" placeholder="휴대폰 번호를 입력해주세요" onChange={onConfirmPasswordHandler}/>
          </div>
          </div> 
          <div class="group">
            <label for="pass" class="label">이메일</label>
            <input style={{ color:'black'}} id="pass" type="email" class="input" placeholder="메일주소를 입력해주세요." onChange={onEmailHandler}/>
            <p style={{ marginTop:'8px' , marginLeft:'400px', fontSize:'13px', cursor:'pointer',  }} onClick={()=>{emailCheck()}} >중복 체크</p>
          </div>  
          <div class="group">
            <label for="user" style={{marginTop:'8px'}} class="label">아이디</label>
            <input style={{ color:'black'}}  id="user" type="text" class="input" placeholder="6~20자 내로 입력해주세요." onChange={onIdHandler}/>
            {/* <Button style={{ marginTop:'8px' , marginLeft:'300px' }} >중복체크</Button> */}
            <p style={{ marginTop:'8px' , marginLeft:'400px', fontSize:'13px', cursor:'pointer' }} onClick={()=>{idCheck()}} >중복 체크</p>
            </div>
          <div class="group">
            <label for="pass" class="label">비밀번호</label>
            <input style={{ color:'black', }} id="pass" type="password" class="input" data-type="password" placeholder="문자, 숫자, 기호를 조합하여 8~20자 내로 입력해주세요."  onChange={onPasswordHanlder}/>
          </div>
          <div class="group">
            <label for="pass" class="label">비밀번호 확인</label>
            <input style={{ color:'black'}} id="pass" type="password" class="input" data-type="password" placeholder="비밀번호를 확인해주세요" onChange={onConfirmPasswordHandler}/>
          </div>
        
          <div  class="group">
            <input style={{ fontSize:'21px' }} type="submit" class="button" value="회원가입" />
          </div>
          <div  style={{ marginTop: '30px'}}class="hr"></div>
          <div class="foot-lnk">
            <label style={{ fontSize: '20px' }} for="tab-1" onClick={()=>{ navigate('/login')}} >비밀번호 기억 나셨나요?</label>
          {/* Already Member? 버튼 누를 경우 login페이지로 랜더링되게 변경 */}
          </div>
        </div>
		</div>
    </div>
  </div>
  </form>
 
      {/* <Toaster
        position="top-center"
        reverseOrder={true}
        toastOptions={{
          duration: 1000,
          style: {
            border: '1px solid #713200',
            padding: '16px',
            margin: '10vh',
            color: '#713200',
          },
        }}
      /> */}
</div>
);
}


export default RegisterPage;