import axios from "axios";

export default axios.create({
    baseURL: "http://192.168.1.7:8080",
    headers: {
        "Content-type": "application/json",
        withCredentials: true
    }
});