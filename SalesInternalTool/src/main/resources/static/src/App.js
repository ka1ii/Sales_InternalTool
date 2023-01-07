import React, { useRef } from "react";
import "./App.css";
import { Button } from "antd";
import "antd/dist/reset.css";

function App() {
  const inputRef = useRef(null);

  const handleBrowseClick = () => {
    // Focus the file input element
    inputRef.current.click();
  };

  const handleSubmitClick = () => {
    // Access the selected file
    const file = inputRef.current.files[0];

    // Create a FormData object to store the file
    const formData = new FormData();
    formData.append("file", file);

    // Send a POST request to the API with the file as the body
    fetch("/api/v1/transactions", {
      method: "POST",
      body: formData,
    })
      .then((response) => response.json())
      .then((data) => {
        console.log(data);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  const handleDownloadClick = async () => {
    const response = await fetch("/api/v1/SellerAchievements");
    const blob = await response.blob();
    const url = URL.createObjectURL(blob);
    const a = document.createElement("a");
    a.style.display = "none";
    a.href = url;
    // the filename you want
    a.download = "seller_achievement.csv";
    document.body.appendChild(a);
    a.click();
  };

  return (
    <div className="App">
      <header className="App-header">
        <div className="box">
          <p>Upload Transactions(CSV)</p>
          <input type="file" onChange={handleBrowseClick} ref={inputRef} />
          <br />
          <br />
          <Button onClick={handleSubmitClick}>Upload Transactions</Button>
          <br />
          <br />
          <br />
          <br />
          <br />
          <p>Download Seller Achievements(CSV)</p>
          <Button onClick={handleDownloadClick}>Download Achievements</Button>
        </div>
      </header>
    </div>
  );
}

export default App;
