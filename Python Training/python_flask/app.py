from flask import Flask,redirect,url_for,render_template,request

app=Flask(__name__)

@app.route("/")
def welcome():
    return render_template("index.html")

@app.route("/success/<int:score>")
def success(score):
    res=""
    if score>=50:
        res="pass"
    else:
        res="fail"
    return render_template("result.html", result=res)

@app.route("/fail/<int:score>")
def fail(score):
    return "hello flask"+ str(score)

@app.route("/result/<int:marks>")
def result(marks):
    result=""
    if marks>50:
        result="success"
    else:
        result="fail"
    
    return redirect(url_for(result,score=marks))

@app.route("/submit",methods=["POST","GET"])
def submit():
    total_score=0
    if request.method=="POST":
        scinece=float(request.form["science"])
        maths=float(request.form["maths"])
        c=float(request.form["c"])
        datascience=float(request.form["datascience"])
        total_score=(scinece+maths+c+datascience)/4
    
    return redirect(url_for("success",score=total_score))

if __name__ =="__main__":
    app.run(debug=True)
