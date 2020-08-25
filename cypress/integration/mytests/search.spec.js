import {SearchPage} from '../pages/SearchPage'
import {ResultPage} from "../pages/ResultPage";

describe('My First Test', () => {
    const searchPage = new SearchPage()
    const resultPage = new ResultPage()
    it('Visits the Google', () => {
        searchPage.open()

        searchPage.search('java')

       resultPage.checkLogo()

        resultPage.checkResults()


    })
})