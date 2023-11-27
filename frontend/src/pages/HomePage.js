import React from 'react';
import {css} from '@emotion/react';
import UploadFiles from "../components/upload-files.component";

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
            <h1 className="title">Upload Files</h1>

            <UploadFiles/>
        </div>
    );
};

export default HomePage;
