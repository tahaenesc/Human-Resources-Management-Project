import styles from "../Css/LoginPage.module.css";
import {useForm} from "react-hook-form";
import {useContext} from "react";
import {LoginContext} from "../context/LoginContext.jsx";
import {useNavigate} from "react-router-dom";

const LoginPage = () => {

    const {handleLogin} = useContext(LoginContext);
    const navigate = useNavigate();

    const {
        register,
        reset,
        formState: {errors, isSubmitting},
        getValues
    } = useForm();

    const handleClearClick = () => {
        reset();
    };

    const handleSubmit = (event) => {
        event.preventDefault();
        handleLogin(getValues());
        navigate('/home');
    }

    return (
        <>
            <div className={styles["register-form-wrapper"]}>
                <form onSubmit={handleSubmit} className={styles["register-form"]}>

                    <label className={styles["label"]}>
                        <span>E-Mail: </span>
                        <input
                            {...register("email", {
                                required: `Cannot be left blank!`,
                            })}
                            type={'email'}
                            placeholder={'E-Mail'}
                            className={styles["textarea"]}
                        />
                        {errors['email'] && (
                            <p className="text-red-500">{errors['email'].message}</p>
                        )}
                    </label>

                    <label className={styles["label"]}>
                        <span>Password: </span>
                        <input
                            {...register("password", {
                                required: `Cannot be left blank!`,
                            })}
                            type={'password'}
                            placeholder={'Password'}
                            className={styles["textarea"]}
                            minLength="4"
                        />
                        {errors['password'] && (
                            <p className="text-red-500">{errors['password'].message}</p>
                        )}
                    </label>

                    <div>
                        <button disabled={isSubmitting} type="submit" className={styles["button"]}>
                            Submit
                        </button>
                        <button type='button' onClick={handleClearClick} className={styles["button"]}>Clear</button>
                    </div>
                </form>
            </div>
        </>
    )
}

export default LoginPage;