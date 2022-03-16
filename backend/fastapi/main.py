from fastapi import FastAPI, File, UploadFile

app = FastAPI()


@app.post("/api/ai/voiceCommand/")
async def executeCommand():
    return "hello fastapi"