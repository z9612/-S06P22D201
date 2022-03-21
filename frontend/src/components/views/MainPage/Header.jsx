import React from 'react'
import styles from './MainPage.css'

export default function Header() {
  return (
    <div className="header">
      <div className='top'>
        <h1 className="logo">
          <a href=''>
            {/* 로고 변경예정 */}
            <img src="https://www.kbanknow.com/resource/img/reform/layout/logo_kbank.png"></img>
          </a>
        </h1>

        <div id="utill">
          <span className='login'>
            {/* 추후 링크 추가 */}
            <a>로그인</a>
          </span>
        </div>
      </div>

      <div className='gnb'>
        <ul className='topGnb'>
          {/* 추후 링크 추가 */}
          <li><a href=''>조회</a></li>
          <li><a href=''>이체</a></li>
          <li><a href=''>대출</a></li>
          <li><a href=''>뱅킹관리</a></li>
        </ul>
      </div>
    </div>
  )
}