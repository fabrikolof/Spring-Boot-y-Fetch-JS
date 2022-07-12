const d = document,
$form = d.querySelector(".crud-form");


//Form
d.addEventListener("submit", async e => {
    if(e.target === $form){
        e.preventDefault();
        //POST

        // console.log(e.target.name.value);
        // console.log(parseInt(e.target.age.value));
        try {
            let options = {
                method: "POST",
                headers: {
                    "Content-type": "application/json; charset=UTF-8",
                },
                body: JSON.stringify({
                    name: e.target.name.value,
                    age: parseInt(e.target.age.value),
                }),
            },
            res = await fetch("http://localhost:8080/user", options),
            json = await res.json();
            
            if (!res.ok) throw { status: res.status, statusText: res.statusText };
            
        } catch (err) {
            let message = err.statusText || "Ocurrió un error";
            $form.insertAdjacentHTML(
                "afterend",
              `<p><b>Error ${err.status}: ${message}</b></p>`
            );
          }

    }
});

