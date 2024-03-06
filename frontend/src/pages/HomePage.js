import React from 'react';
import {css} from '@emotion/react';
import UploadFiles from "../components/upload-files.component";
import mainLogo from '../assets/czippy.png';

const HomePageStyle = css`
    h1 {
        font-size: 5rem;
        font-weight: 600;
        text-align: center;
    }
`;

const HomePage = () => {
    return (
        <div css={[HomePageStyle]}>
            <div style={{marginBottom: '2em'}}>
                <img src={mainLogo} style={{scale: '80%'}} alt="CZIPPY"/>
            </div>

            <UploadFiles/>

        </div>
    );
};
export default HomePage;
