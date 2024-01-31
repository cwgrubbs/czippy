import http from "../http-common";

class UploadFilesService {
    upload(file, onUploadProgress) {
        let formData = new FormData();

        formData.append("file", file);

        return http.post("/api/upload", formData, {
            headers: {
                "Content-Type": "multipart/form-data",
            },
            onUploadProgress,
            auth: {
                username: 'user',
                password: 'password'
            }
        });
    }

    getFiles() {
        return http.get("/api/files", {
            auth: {
                username: 'user',
                password: 'password'
            }
        });
    }
}

export default new UploadFilesService();
