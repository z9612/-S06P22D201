from fastapi import FastAPI, File, UploadFile

app = FastAPI()


@app.post("/api/ai/voiceCommand/")
async def executeCommand(file : UploadFile = File(...)):
    return "hello fastapi"