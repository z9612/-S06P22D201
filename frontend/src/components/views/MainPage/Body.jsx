import React, { useEffect, useState } from 'react'
import Carousel from 'react-bootstrap/Carousel'
import { run as runHolder } from 'holderjs/holder';
import styles from './MainPage.css'

export default function M_Body() {

  return (
    <div className="m_body">
      <Carousel1></Carousel1>

      <div className='quickMenu'>
        <ul className='listQuickMenu'>
          <li><a href=""><span className='icoSearch'>조회하기</span></a></li>
          <li><a href=""><span className='icoTransfer'>이체하기</span></a></li>
          <li><a href=""><span className='icoLoan'>대출</span></a></li>
          <li><a href=""><span className='icoBank'>뱅킹관리</span></a></li>
        </ul>
      </div>

      <div className='sub_cont'>
        <div className='main_notice'>
          <div>
            <h3 className='black'>공지사항</h3>
            <ul id='noticeListUI'>
              <li>
                <span>2022.02.21</span>
                <p><a href='' className='noticeDet'>무카드거래 서비스 보이스피싱을 주의하세요</a></p>
              </li>
              <li>
                <span>2022.03.16</span>
                <p><a href='' className='noticeDet'>수신상품 금리 변경 안내</a></p>
              </li>
              <li>
                <span>2022.03.10</span>
                <p><a href='' className='noticeDet'>연락처 송금 서비스가 리뉴얼 됩니다.</a></p>
              </li>
              <li>
                <span>2022.03.08</span>
                <p><a href='' className='noticeDet'>개인정보처리 위탁/제휴 및 영상정보처리기기관리방침 변경 안내</a></p>
              </li>
            </ul>
            <a href='' className='user_more' id='gongsi_more'>더보기</a>
          </div>

          <div>
            <h3 className='black'>혜택존</h3>
            <ul id='eventListUI'>
              <li>
                <span>2022.03.15 ~ 2022.04.14</span>
                <p><a href='' className='eventDet'>챌린지박스 이벤트</a></p>
              </li>
              <li>
                <span>2022.03.01 ~ 2022.03.31</span>
                <p><a href='' className='eventDet'>SIMPLE카드 12만원 이벤트</a></p>
              </li>
              <li>
                <span>2022.02.23 ~ 2022.05.25</span>
                <p><a href='' className='eventDet'>당근페이 제휴 이벤트</a></p>
              </li>
              <li>
                <span>2022.02.21 ~ 2022.03.27</span>
                <p><a href='' className='eventDet'>내 신용관리 이벤트</a></p>
              </li>
            </ul>
            <a href='' className='user_more' id='event_more'>더보기</a>
          </div>

          <div>
            <h3 className='black'>상품 공시실</h3>
            <ul id='productListUI'>
              <li>
                <span>2022.03.15</span>
                <p><a href='' className='gongsiDet'>[카드] 케이뱅크 X 해피포인트 체크카드</a></p>
              </li>
              <li>
                <span>2021.07.07</span>
                <p><a href='' className='gongsiDet'>[예금] 핫딜예금 X KB손해보험</a></p>
              </li>
              <li>
                <span>2021.07.01</span>
                <p><a href='' className='gongsiDet'>[예금] 코드K 자유적금(GS프레시몰 이벤트)</a></p>
              </li>
              <li>
                <span>2022.04.26</span>
                <p><a href='' className='gongsiDet'>[예금] 주거래우대 정기예금</a></p>
              </li>
            </ul>
            <a href='' className='user_more' id='event_more'>더보기</a>
          </div>
        </div>
      </div>

    </div>
  )
}


function Carousel1() {
  useEffect(() => { runHolder('image-class-name'); });

  return (
    <Carousel>
      <Carousel.Item>
        <img
          className="d-block w-100"
          src="holder.js/1200x400?text=First slide&bg=373940"
          alt="First slide"
        />
        <Carousel.Caption>
          <h3>First slide label</h3>
          <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
        </Carousel.Caption>
      </Carousel.Item>
      <Carousel.Item>
        <img
          className="d-block w-100"
          src="holder.js/1200x400?text=Second slide&bg=282c34"
          alt="Second slide"
        />

        <Carousel.Caption>
          <h3>Second slide label</h3>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
        </Carousel.Caption>
      </Carousel.Item>
      <Carousel.Item>
        <img
          className="d-block w-100"
          src="holder.js/1200x400?text=Third slide&bg=20232a"
          alt="Third slide"
        />

        <Carousel.Caption>
          <h3>Third slide label</h3>
          <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
        </Carousel.Caption>
      </Carousel.Item>
    </Carousel>
  )
}


