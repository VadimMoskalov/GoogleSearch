export class ResultPage{

    getLogo(){return cy.get("[id='logo']>img")}

    getResults(){return cy.get("[class='g']")}


    checkLogo(){
        this.getLogo().should('be.visible')
    }

    checkResults(){
        let count = 0
        this.getResults().each(($el, $index, $list) => {
            let temp = $index / 2

            if ($index === 0) {
                cy.wrap($el).children("div").children("div").children("div").children("a").children("h3").should(($h) => {
                    const text = $h.text()
                    expect(text).to.contains("Java")
                })
            } else {
                cy.wrap($el).children("div").children("div").children("a").children("h3").should(($h) => {
                    let text = $h.text();

                    if (text.includes("Java")) {
                        count++;
                    }
                    expect(count).to.be.greaterThan(temp)
                })
            }
        })
    }


}