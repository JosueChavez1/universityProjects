  function ingresarValores() {
            const n = parseInt(document.getElementById("cantidadValores").value);

            if (n > 5 && n <= 15) {
                document.getElementById("valoresInput").innerHTML = "";
                for (let i = 1; i <= n; i++) {
                    const label = document.createElement("label");
                    label.innerHTML = `Valor #${i}:`;
                    const input = document.createElement("input");
                    input.type = "number";
                    input.min = 10;
                    input.max = 100;
                    document.getElementById("valoresInput").appendChild(label);
                    document.getElementById("valoresInput").appendChild(input);
                }

                document.getElementById("valoresInput").style.display = "block";
                document.getElementById("calcularMediaButton").style.display = "block";
            } else {
                alert("La cantidad de valores debe estar entre 6 y 15.");
            }
        }

        function calcularMedia() {
            const inputs = document.querySelectorAll("#valoresInput input");
            let suma = 0;
            let cantidadValores = 0;

            inputs.forEach(input => {
                const valor = parseFloat(input.value);
                if (valor >= 10 && valor <= 100) {
                    suma += valor;
                    cantidadValores++;
                }
            });

            if (cantidadValores > 0) {
                const media = suma / cantidadValores;
                document.getElementById("resultado").innerHTML = `La media de los valores es: ${media.toFixed(2)}`;
                document.getElementById("resultado").style.display = "block";
            } else {
                alert("Al menos un valor debe estar entre 10 y 100.");
            }
        }